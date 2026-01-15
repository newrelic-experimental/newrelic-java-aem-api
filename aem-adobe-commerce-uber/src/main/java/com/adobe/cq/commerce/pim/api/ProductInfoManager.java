package com.adobe.cq.commerce.pim.api;

import java.util.List;

import com.adobe.cq.commerce.api.Product;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface)
public abstract class ProductInfoManager {

	@Trace
	public List<Product> findProductsByTag(String var1, String[] var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","ProductInfoManager",getClass().getSimpleName(),"findProductsByTag");
		return Weaver.callOriginal();
	}

	@Trace
	public List<Product> findProductsBySearch(String var1, String var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","ProductInfoManager",getClass().getSimpleName(),"findProductsBySearch");
		return Weaver.callOriginal();
	}

	@Trace
	public List<Product> findProductsByQuery(String var1, String var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","ProductInfoManager",getClass().getSimpleName(),"findProductsByQuery");
		return Weaver.callOriginal();
	}

}
