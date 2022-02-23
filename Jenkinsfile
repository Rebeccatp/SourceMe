// Powered by Infostretch 

timestamps {

node () {

	stage ('SourceMe - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '*/tutorialBranch']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'c215e154-c595-4b87-a48e-0f671ecbc2af', url: 'https://github.com/Rebeccatp/SourceMe.git']]]) 
	}
	stage ('SourceMe - Build') {
 			// Maven build step
	withMaven(maven: 'maven 3.8.2') { 
 			if(isUnix()) {
 				sh "mvn -f SourceMe/pom.xml clean install test " 
			} else { 
 				bat "mvn -f SourceMe/pom.xml clean install test " 
			} 
 		} 
	}
}
}