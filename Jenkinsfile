pipeline{
 agent any
    stages {
        stage ('Compile Stage') {

            steps {
             echo "::::in compile stage"
             withMaven(maven : 'maven-3') {
                      bat 'mvn clean compile'

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

