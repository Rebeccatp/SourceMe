pipeline {
    agent any  
    stages {
        stage('sourceme - Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/tutorialBranch']], 
                doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], 
                userRemoteConfigs: [[credentialsId: 'c215e154-c595-4b87-a48e-0f671ecbc2af', url: 'https://github.com/Rebeccatp/SourceMe.git']]])
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
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: '2004556C@student.tp.edu.sg', sendToIndividuals: false])
        }  
        unstable {
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: '2004556C@student.tp.edu.sg', sendToIndividuals: false])
        }
    }
}
