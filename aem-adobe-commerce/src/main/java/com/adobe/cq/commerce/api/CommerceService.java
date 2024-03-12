package com.adobe.cq.commerce.api;

import java.util.HashMap;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.aem.commerce.Utils;

@Weave(type = MatchType.Interface)
public abstract class CommerceService {

	public abstract String getServer();

	@Trace(dispatcher = true)
	public CommerceResult search(CommerceQuery query) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","CommerceService",getClass().getSimpleName(),"search");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addAttribute(attributes, "Server", getServer());
		if(query != null) {
			Utils.addAttribute(attributes, "Query", query.getQueryText());
		}
		if(!attributes.isEmpty()) {
			traced.addCustomAttributes(attributes);
		}
		return Weaver.callOriginal();
	}
}
