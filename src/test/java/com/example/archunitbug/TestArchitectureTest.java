package com.example.archunitbug;

import com.example.archunitbug.rules.TestRules;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import com.tngtech.archunit.junit.CacheMode;

@AnalyzeClasses(packages = "com.example.archunitbug",
        importOptions = {
                ImportOption.OnlyIncludeTests.class,
                ImportOption.DoNotIncludePackageInfos.class,
                ImportOption.DoNotIncludeArchives.class
        },
        cacheMode = CacheMode.PER_CLASS)
public class TestArchitectureTest {

    @ArchTest
    static final ArchTests testRules = ArchTests.in(TestRules.class);


}
