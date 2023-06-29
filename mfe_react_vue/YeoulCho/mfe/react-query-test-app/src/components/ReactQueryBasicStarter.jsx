import React from 'react'
import axios from 'axios'
import { QueryClient, QueryClientProvider, useQuery } from 'react-query'

const queryClient = new QueryClient()
export const ReactQueryBasicStarter = () =>{
    return(
    //v vuex actions의 역할의 컴포넌트들과 연결한다 보면 됨    
    <QueryClientProvider client={queryClient}>
        <ReactQueryExecutor/>
    </QueryClientProvider>
    )
}

const ReactQueryExecutor = () => {
  const { isLoading, error, data, isFetching} = useQuery("repoData", ()=>
    axios.get(
        "https://api.github.com/repos/yeoulcho/KDT-AI-1-LectureNotes"
    )
    .then((res)=>res.data)
    .catch((res=>res.data))
    
  )

  if(isLoading) return "로딩중..........."
  
  if(error) return "에러발생: " + error.message

  console.log('data: ' + data)
    return (
    <div>
        <h1>{data.name}</h1>
    </div>
  )
}

