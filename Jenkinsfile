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
			    def token = bat(script: "curl -H \"Content-Type: application/json\" -X POST --data '{ \"client_id\": \"${client_id}\",\"client_secret\": \"${client_secret}\" }' ${xray_server}/api/v1/authenticate", returnStdout: true)
                                echo "Authentication token: ${token}"
			    
			    echo "Creating info file for Test Exec..."
                                def meta = readJSON text: "{ \
                                        \"fields\": { \
                                            \"project\": { \
                                                \"key\": \"BDD\" \
                                            }, \
                                            \"issuetype\": { \
                                                \"id\": \"10014\" \
                                            }, \

                                            \"fixVersions\": [ \
                                              { \
                                                \"name\": \"1.0\" \
                                              } \
                                            ] \
                                        } \
                                    }"
                                writeJSON file: "info.json", json: meta

                                echo "Uploading results to Xray..."
                                sh "curl -H \"Content-Type: multipart/form-data\" -X POST -H \"Authorization: Bearer ${token}\" -F results=@output-json2.json -F info=@info.json ${xray_server}/api/v1/import/execution/cucumber"
		
		}
	    }
    }
		

    }
   
 }

