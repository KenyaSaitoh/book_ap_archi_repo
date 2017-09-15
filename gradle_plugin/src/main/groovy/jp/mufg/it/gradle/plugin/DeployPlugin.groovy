package jp.mufg.it.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class DeployPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('param', DeployPluginConfiguration);
        project.task("deployGlassFish", type: Exec) << {
            def conf = ConfigManager.getConfig(project)
            print project.param.warFile
            exec {
                executable conf.glassfish.asadmin
                args "--user", conf.glassfish.adminUsername
                args "--host", conf.glassfish.hostName
                args "--port", conf.glassfish.adminPort
                args "deploy"
                args "--force", true
                args project.param.warFile
            }
        }
    }
}

class DeployPluginConfiguration {
    String warFile
}