package com.waverleysoftware.basecore;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

/**
 * A convenient Java interface for processing properties.
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config.properties")
public interface BaseConfig extends Config, Reloadable {

    BaseConfig BASE_CONFIG = ConfigFactory.create(BaseConfig.class, System.getenv(), System.getProperties());

    @Key("explicit.wait.timeout")
    @DefaultValue("3")
    long waitTimeout();

    @Key("url")
    @DefaultValue("${URL}")
    String url();

    @Key("separator")
    @DefaultValue(",")
    String separator();
}
