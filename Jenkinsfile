pipeline {
    agent any  
    stages {
        stage('sourceme - Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/userBranch2']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'f164b462-b5f8-49e9-82be-50990656423c', url: 'https://github.com/Rebeccatp/SourceMe']]])
            }  
        }
        stage ('sourceme - Build') {
            steps {
                // Maven build step
                withMaven(maven: 'Maven 3.8.2') {
                    bat "mvn -f SourceMe/pom.xml clean install test "
                }
            }
        }
        stage ('sourceme - Deploy') {
            steps {
                deploy(
                    adapters: [tomcat7(url: 'http://localhost:8080/', credentialsId: 'e3cbf20e-4922-4385-a5c6-cb93c4de32ce')],
                    war: '**/*.war',
                    contextPath: 'sourceme-pipeline'
                )
            }
        }
    }
    post {
        failure {
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: '2001356A@student.tp.edu.sg', sendToIndividuals: false])
        }  
        unstable {
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: '2001356A@student.tp.edu.sg', sendToIndividuals: false])
        }
    }
}
