// Powered by Infostretch 

timestamps {

node () {

	stage ('sourceme - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '*/userBranch2']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'f164b462-b5f8-49e9-82be-50990656423c', url: 'https://github.com/Rebeccatp/SourceMe']]]) 
	}
	stage ('sourceme - Build') {
 			// Maven build step
	withMaven(maven: 'Maven 3.8.2') { 
 			if(isUnix()) {
 				sh "mvn -f SourceMe/pom.xml clean install test " 
			} else { 
 				bat "mvn -f SourceMe/pom.xml clean install test " 
			} 
 		} 
	}
}
}
