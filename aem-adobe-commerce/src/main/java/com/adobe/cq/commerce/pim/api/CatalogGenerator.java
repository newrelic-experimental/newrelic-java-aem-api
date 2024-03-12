package com.adobe.cq.commerce.pim.api;

import java.util.HashMap;

import org.apache.sling.api.resource.Resource;

import com.adobe.cq.commerce.api.Product;
import com.day.cq.wcm.api.Page;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.aem.commerce.Utils;

@Weave(type = MatchType.Interface)
public abstract class CatalogGenerator {

	@Trace(dispatcher = true)
	public Page createCatalog(Page page, String var2, String var3, String var4, String... var5) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","CatalogGenerator",getClass().getSimpleName(),"createCatalog");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addPage(attributes, page, "InputPage");
		Page resultPage = Weaver.callOriginal();
		Utils.addPage(attributes, page, "ReturnedPage");
		return resultPage;
	}
	
	@Trace(dispatcher = true)
	public void rolloutChanges(Page var1, Page var2, boolean var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","CatalogGenerator",getClass().getSimpleName(),"rolloutChanges");
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher = true)
	public void convertToEditablePage(Page var1, Page var2, Product var3) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","CatalogGenerator",getClass().getSimpleName(),"convertToEditablePage");
		Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public void executePageRolloutHooks(Page var1, boolean var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","CatalogGenerator",getClass().getSimpleName(),"executePageRolloutHooks");
		Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public void executeProductRolloutHooks(Resource var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","CatalogGenerator",getClass().getSimpleName(),"executeProductRolloutHooks");
		Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public void updateProduct(Resource var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","CatalogGenerator",getClass().getSimpleName(),"updateProduct");
		Weaver.callOriginal();
	}

	@Trace(dispatcher = true)
	public void updateProductAssets(Resource var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AEM","CatalogGenerator",getClass().getSimpleName(),"updateProductAssets");
		Weaver.callOriginal();
	}

}
