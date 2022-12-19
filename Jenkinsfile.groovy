pipeline {
    agent any
    stages {
        stage('Check') {
            sshagent(credentials: ['ansible_user']) {
                steps {
                    sh 'pwd'
                    sh 'ls -la'
                    ansiblePlaybook playbook: 'playbook.yml', inventory: 'hosts'
                }
            }
        }
    }
}