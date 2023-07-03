import React from 'react'

import { QueryClient, QueryClientProvider, useQuery } from 'react-query'
import axios from 'axios'

const queryClient = new QueryClient()
export const ReactQueryBasicStarter = () => {
  return (
    // vuex actions의 역할의 컴포넌트들과 연결한다 보면 됨
    <QueryClientProvider client={queryClient}>
      <ReactQueryExecutor/>
    </QueryClientProvider>
  )
}

const ReactQueryExecutor = () => {
  const { isLoading, error, data, isFetching } = useQuery("repoData", () => 
    axios.get(
      "https://api.github.com/repos/silenc3502/backend-for-aws-deploy-test"
    )
    .then((res) => res.data)
  )

  if (isLoading) return "로딩중 ........"

  if (error) return "에러 발생: " + error.message

  return (
    <div>
      <h1>{ data.name }</h1>
    </div>
  )
}
