package com.adobe.cq.commerce.api.asset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.commerce.api.CommerceException;
import com.adobe.cq.commerce.api.Product;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.aem.commerce.Utils;

@Weave(type = MatchType.Interface)
public abstract class ProductAssetManager {

	@Trace
	public Resource getAsset(Product product) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductAssetManager",getClass().getSimpleName(),"getAsset");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addProduct(attributes, product);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public List<Resource> getAssets(Product product) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductAssetManager",getClass().getSimpleName(),"getAssets");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addProduct(attributes, product);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public Resource addAsset(Product product, String var2) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductAssetManager",getClass().getSimpleName(),"addAsset");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addProduct(attributes, product);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public	Resource addAsset(Product product, Map<String, Object> var2) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductAssetManager",getClass().getSimpleName(),"addAsset");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addProduct(attributes, product);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public 	Resource updateAsset(String var1, String var2) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductAssetManager",getClass().getSimpleName(),"updateAsset");
		return Weaver.callOriginal();
	}

	@Trace
	public 	Resource updateAsset(String var1, Map<String, Object> var2) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductAssetManager",getClass().getSimpleName(),"updateAsset");
		return Weaver.callOriginal();
	}

	@Trace
	public 	void removeAsset(String var1) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","ProductAssetManager",getClass().getSimpleName(),"removeAsset");
		Weaver.callOriginal();
	}

}
