pipeline{
 agent any
 environment{
	 xray_server = "http://id.atlassian.com/login/"
        client_id = "C0D11335784348A880B9EC62F0829C7B"
        client_secret = "37ae95c138c62e00c0e1a13dbdef0b201ffbe9f89695a398e5bbf5c3368cd04e"	 
 }
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
    stage('Import results to Xray') {
	    steps{
		    script{
		def testExecutionFieldId = 10014
		def projectKey = "BDD"
		def xrayConnectorId = '75fd9872-0773-4762-861d-6a25c59e1e2e'
		def info = '''{
				"fields": {
					"project": {
					"key": "''' + projectKey + '''"
				},
				"issuetype": {
				"id": "''' + testExecutionFieldId + '''"
				}
				}
				}'''

			echo info
			step([$class: 'XrayImportBuilder', endpointName: '/cucumber', importFilePath: 'output-json2.json', importInfo: info, inputInfoSwitcher: 'fileContent', serverInstance: xrayConnectorId])
			
		}
	    }
    }
		

    }
   
 }

