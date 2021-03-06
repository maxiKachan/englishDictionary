package com.maximKachan.englishDictionary.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

public class DbPopulator extends ResourceDatabasePopulator {
    private static final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader();

    private final DataSource dataSource;

    public DbPopulator(String scriptLocation, DataSource dataSource){
        super(RESOURCE_LOADER.getResource(scriptLocation));
        this.dataSource = dataSource;
        setSqlScriptEncoding("UTF-8");
    }

    public void execute(){
        execute(dataSource);
    }
}
