package jp.mufg.it.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigManager {

    static def getConfig(Project project) {
        def configDir = "${System.properties['user.home']}"

        // 設定情報の読み込み
        def conf = {
            def slurper = new ConfigSlurper()
            slurper.binding = project.properties
            def files = [ new File("${configDir}/ap-archi-conf.gradle") ]
            files.inject(new ConfigObject()) { conf, file ->
                file.exists() ? conf.merge(slurper.parse(file.toURL())) : conf
            }
        }()
        return conf
    }
}