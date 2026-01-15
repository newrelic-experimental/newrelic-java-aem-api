package com.adobe.cq.commerce.pim.api;

import java.util.List;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;

import com.adobe.cq.commerce.api.Product;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface)
public abstract class ProductListDecorator {

	@Trace
	public List<Map<String, Object>> process(SlingHttpServletRequest var1, SlingHttpServletResponse var2, List<Product> var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","ProductListDecorator",getClass().getSimpleName(),"process");
		return Weaver.callOriginal();
	}

}
