pipeline{
    agent any 
     parameters {
	   string defaultValue:'https://github.com/bhavyapandey/ci-demo.git' ,description: 'https URL', name: 'Git_repo_url'
	    string defaultValue: 'any', description: 'Environmente', name: 'TARGET_ENV'
    }
    stages{
        stage('JOb prerparation'){
            steps{
                script{
                    cleanWs()
                    println("Preparing job with variables")
                    currentBuild.displayName = "#${BUILD_NUMBER} Started by ${currentBuild.getBuildCauses()[0].userId}"
                    currentBuild.description = """Environment selected: ${TARGET_ENV}, git repo url :${Git_repo_url}"""
                }
            }
        }
        stage('git clone'){
            steps{
                git branch: 'main', changelog: false, credentialsId: 'github_bhavya_id', poll: false, url: Git_repo_url
            }
        }
        stage('Readfile'){
            steps{
                script{
                    fileexist = fileExists 'README.md'
                    if(fileexist){
                        def file = readFile 'README.md'
                        println(file)
                    } else{
                        println("No readme file")
                    }
                  cleanWs()
                }
            }
        }
    }
}
