package com.adobe.cq.commerce.api.promotion;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;

import com.adobe.cq.commerce.api.CommerceSession;
import com.adobe.cq.commerce.api.PriceInfo;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.aem.commerce.Utils;

@Weave(type = MatchType.Interface)
public class PromotionHandler {

	@Trace
	public PriceInfo applyCartEntryPromotion(CommerceSession var1, Promotion promotion, CommerceSession.CartEntry var3) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","PromotionHandler",getClass().getSimpleName(),"applyCartEntryPromotion");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addPromotion(attributes, promotion);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
	
	@Trace
	public PriceInfo applyOrderPromotion(CommerceSession var1, Promotion promotion) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","PromotionHandler",getClass().getSimpleName(),"applyOrderPromotion");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addPromotion(attributes, promotion);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public PriceInfo applyShippingPromotion(CommerceSession var1, Promotion promotion) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","PromotionHandler",getClass().getSimpleName(),"applyShippingPromotion");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addPromotion(attributes, promotion);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public String getDescription(SlingHttpServletRequest var1, CommerceSession var2, Promotion promotion) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","PromotionHandler",getClass().getSimpleName(),"getDescription");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addPromotion(attributes, promotion);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public Map<Integer, String> getMessages(SlingHttpServletRequest var1, CommerceSession var2, Promotion promotion) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","PromotionHandler",getClass().getSimpleName(),"getMessages");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addPromotion(attributes, promotion);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

}
