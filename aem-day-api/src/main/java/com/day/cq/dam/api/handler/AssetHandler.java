package com.day.cq.dam.api.handler;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.adobe.granite.asset.api.AssetRelation;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.dam.api.thumbnail.ThumbnailConfig;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.adobe.aem.api.Utils;


@Weave(type = MatchType.Interface)
public abstract class AssetHandler {

	@Trace
	public void createThumbnails(Asset asset, Collection<ThumbnailConfig> config) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","Dam","AssetHandler",getClass().getSimpleName(),"createThumbnails");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayAsset(attributes, asset);
		traced.addCustomAttributes(attributes);
		Weaver.callOriginal();
	}

	@Trace
	public void createThumbnails(Asset asset) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","Dam","AssetHandler",getClass().getSimpleName(),"createThumbnails");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayAsset(attributes, asset);
		traced.addCustomAttributes(attributes);
		Weaver.callOriginal();
	}

	@Trace
	public void createThumbnails(Asset asset, Rendition var2, Collection<ThumbnailConfig> var3) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","Dam","AssetHandler",getClass().getSimpleName(),"createThumbnails");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayAsset(attributes, asset);
		traced.addCustomAttributes(attributes);
		Weaver.callOriginal();
	}

	@Trace
	public void exportAsset(Asset asset, OutputStream var2) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","Dam","AssetHandler",getClass().getSimpleName(),"exportAsset");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayAsset(attributes, asset);
		traced.addCustomAttributes(attributes);
		Weaver.callOriginal();
	}

	@Trace
	public BufferedImage getImage(Rendition rendition) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","Dam","AssetHandler",getClass().getSimpleName(),"getImage");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayRendition(attributes, rendition);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public BufferedImage getImage(Rendition rendition, Dimension var2) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","Dam","AssetHandler",getClass().getSimpleName(),"getImage");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayRendition(attributes, rendition);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();		
	}

	@Trace
	public List<String> processSubAssets(Asset asset) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","Dam","AssetHandler",getClass().getSimpleName(),"processSubAssets");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayAsset(attributes, asset);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}

	@Trace
	public Iterator<? extends AssetRelation> processRelated(Asset asset) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","Dam","AssetHandler",getClass().getSimpleName(),"processRelated");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayAsset(attributes, asset);
		traced.addCustomAttributes(attributes);
		return Weaver.callOriginal();
	}
}
