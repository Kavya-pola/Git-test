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
		
			    
			   def response = bat(script: 'curl -H "Content-Type: application/json" -X POST -u kavyapola51@gmail.com:jirabdd10 --data @output-json2.json http://id.atlassian.com/rest/raven/1.0/import/execution/cucumber')
			echo response	
		}
	    }
    }
		

    }
   
 }

