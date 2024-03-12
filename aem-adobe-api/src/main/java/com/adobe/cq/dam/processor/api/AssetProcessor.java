package com.adobe.cq.dam.processor.api;

import java.util.HashMap;

import com.day.cq.dam.api.Asset;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.aem.Utils;

@Weave(type = MatchType.Interface)
public abstract class AssetProcessor {

	@Trace
	public boolean processAsset(Asset asset) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","AssetProcessor",getClass().getSimpleName(),"processAsset");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addAsset(attributes, asset);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
}
