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
curl --basic --user kavyapola51@gmail.com:jirabdd10 -F "file=@output-json2.json"
http://id.atlassian.com/rest/atm/1.0/automation/execution/cucumber/BDD?autoCreateTestCases=false
			
		}
	    }
    }
		

    }
   
 }

