// Powered by Infostretch 

timestamps {

node () {

	stage ('sourceme-project - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '*/answersBranch']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '5ca82605-a71c-48b9-bbff-d98172497237', url: 'https://github.com/Rebeccatp/SourceMe']]]) 
	}
	stage ('sourceme-project - Build') {
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