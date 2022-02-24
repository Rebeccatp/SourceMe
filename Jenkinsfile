pipeline {
    agent any
        stages {
            stage('sourceme - Checkout') {
                steps {
                    checkout([$class: 'GitSCM', branches: [[name: '*/answersBranch']],
                    doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: '5ca82605-a71c-48b9-bbff-d98172497237', url: 'https://github.com/Rebeccatp/SourceMe.git']]])
}
}
            stage ('sourceme - Build') {
                steps {
                // Maven build step
                withMaven(maven: 'maven 3.8.2') {
                bat "mvn -f SourceMe/pom.xml clean install test "
            }
                }
                    }
                        }
    post {
        failure {
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: '2005309F@student.tp.edu.sg', sendToIndividuals: false])
        }
    unstable {
        step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: '2005309F@student.tp.edu.sg', sendToIndividuals: false])
        }
    }
}
