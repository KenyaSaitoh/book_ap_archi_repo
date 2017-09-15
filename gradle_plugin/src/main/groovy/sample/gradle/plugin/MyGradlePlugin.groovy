package sample.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyGradlePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('param', MyGradlePluginConfiguration);

        project.task('printValue') << {
            println "This is ${project.param.value}!!!"
        }
    }
}

class MyGradlePluginConfiguration {
    String value
}