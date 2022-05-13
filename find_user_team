def user_list =[]
def dev_team = ['daniel','rita','charles','lewis']
def test_team = ['micheal','seb','tina']
def user_map = [:]


pipeline{
    agent { label "any" }
    parameters {
	   string description: 'can enter more than user. (separate using a comma)', name: 'user'
    }
    stages{
        stage('Checking team'){
            steps{
                script{
                    println("Users entered : $user")
                    user_list = user.split(',')
                    user_list.each {
                        echo "Checking team for : $it ..."
                        if(dev_team.contains(it)){
                            echo "Member of DEV team"
                            user_map.put(it, 'DEV')
                        } else if(test_team.contains(it)){
                            echo "Member of TEST team"                            
                            user_map.put(it,'TEST')
                        } else {
                            echo "Memeber of no team."                            
                            user_map.put(it,'NONE')
                        }                        
                    }
                    println(user_map)
                }
            }
        }
    }    
}

