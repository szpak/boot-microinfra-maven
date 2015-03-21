project(modelVersion: '4.0.0') {

    groupId 'com.devskiller.maven'
    artifactId 'sample-groovy-maven'
    version '1.0-SNAPSHOT'

    def groovyVersion = '2.4.2'
    def springBootVersion = '1.2.2.RELEASE'
    def microInfraSpringVersion = '0.8.14'

    properties {
        'project.build.sourceEncoding' 'UTF-8'
        'start-class' 'demo.DemoApplication'
        'java.version' 1.8
    }

    parent(groupId: 'org.springframework.boot', artifactId: 'spring-boot-starter-parent', version: springBootVersion) {
        relativePath()
    }

    repositories {
        repository(id: 'jcenter', url: 'http://jcenter.bintray.com')
    }

    dependencies {
        dependency(groupId: 'org.springframework.boot', artifactId: 'spring-boot-starter-web')
        dependency(groupId: 'com.ofg', artifactId: 'micro-infra-spring-boot-starter', version: microInfraSpringVersion)  {
            exclusions {
                exclusion groupId: 'org.codehaus.groovy', artifactId: 'groovy-all'
            }
        }
        dependency(groupId: 'org.codehaus.groovy', artifactId: 'groovy-all', version: groovyVersion, classifier: 'indy')
    }

    build {
        plugins {
            plugin(groupId: 'org.springframework.boot', artifactId: 'spring-boot-maven-plugin')
            plugin(groupId: 'org.codehaus.gmavenplus', artifactId: 'gmavenplus-plugin', version: 1.5) {
                executions {
                    execution {
                        goals {
                            goal 'compile'
                        }
                    }
                }
                configuration {
                    invokeDynamic true
                }
            }
        }
    }
}