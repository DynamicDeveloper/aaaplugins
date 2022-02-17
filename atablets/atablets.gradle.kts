

version = "1.0.3"

project.extra["PluginName"] = "ATablets"
project.extra["PluginDescription"] = "Anarchise' Tablet Maker"
project.extra["PluginProvider"] = "Anarchise"
project.extra["PluginSupportUrl"] = "https://discord.com/invite/aplugins"

dependencies {
    compileOnly(project(":autils"))
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }

}
tasks {
    jar {
        manifest {
            attributes(mapOf(
                "Plugin-Version" to project.version,
                "Plugin-Id" to nameToId(project.extra["PluginName"] as String),
                "Plugin-Provider" to project.extra["PluginProvider"],
                "Plugin-Dependencies" to
                        arrayOf(
                            nameToId("AUtils")
                        ).joinToString(),
                "Plugin-Description" to project.extra["PluginDescription"],
                "Plugin-License" to project.extra["PluginLicense"]
            ))
        }
    }
}