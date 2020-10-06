pipeline{
 agent any
    stages {
        stage ('Build Stage') {

            steps {
             echo "::::in compile stage"
             withMaven(maven : 'maven-3') {
                      bat 'mvn clean build'

					         }
               
            }
        }

        stage ('Testing Stage') {

            steps {
                echo "::::in test stage"
             withMaven(maven : 'maven-3') {
                    bat 'mvn test'
                }
              
            }
        }
  
   }
 }

