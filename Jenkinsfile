pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // 소스코드 체크아웃
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Java 파일들을 컴파일하여 생성된 클래스 파일을 classes 디렉토리에 저장
                    def classpath = "lib/junit-jupiter-5.8.1.jar:lib/*"
                    sh "javac -encoding UTF-8 -d classes -cp ${classpath} src/*.java test/*.java"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    
                }
            }
        }
    }

    post {
        always {
            // 테스트 결과 파일을 저장하기 위해 아카이브
            archiveArtifacts artifacts: 'test_results.txt', allowEmptyArchive: true
        }
        failure {
            echo 'Build or test failed'
        }
        success {
            echo 'Build and test succeeded'
        }
    }
}
