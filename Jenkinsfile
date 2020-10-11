pipeline{
 agent any
 tools {
        maven 'maven-3'
        jdk 'jdk8'
    }
    stages {
        stage ('Build Stage') {

            steps {
             bat 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
      }
    post{
 always{
	step([$class: 'XrayImportBuilder',
		  endpointName: '/cucumber',
		  importFilePath: 'output-json2.json',
		  importToSameExecution: 'true',
		  projectKey: 'BDD',
		  serverInstance: '75fd9872-0773-4762-861d-6a25c59e1e2e'])
 }
}
 }

