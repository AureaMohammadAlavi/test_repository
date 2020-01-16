pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                gradlew('clean', 'classes')
            }
        }
        stage('Assemble') {
            steps {
                gradlew('assemble')
            }
        }
        stage('Publish to Bintray') {
            environment {
               BINTRAY_API_KEY=credentials('BINTRAY_API_KEY')
            }
            steps {
                gradlew('bintrayUpload')
            }
        }
    }
}

def gradlew(String... args) {
    sh "./gradlew ${args.join(' ')} -s"
}