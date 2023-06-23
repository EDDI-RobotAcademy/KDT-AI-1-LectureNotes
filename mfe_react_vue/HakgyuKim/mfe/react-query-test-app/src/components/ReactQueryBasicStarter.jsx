import React from 'react'

import { QueryClient, QueryClientProvider, useQuery } from 'react-query'
import axios from 'axios'

const queryClient = new QueryClient()
export const ReactQueryBasicStarter = () => {
  return (
    <QueryClientProvider client={queryClient}>
      <ReactQueryExecutor/>
    </QueryClientProvider>
  )
}
 
const ReactQueryExecutor = () => {
  const { isLoading, error, data, isFetching } = useQuery("repoData", () => 
    axios.get(
      "http://api.github.com/repos/silenc3502/backend-for-aws-deploy-test"
    )
    .then((res) => res.data)
  )

  if (isLoading) return "로딩중 .........."

  if (error) return "에러 발생: " + error.message

  return (
    <div>
      <h1>{ data.name }</h1>
  </div>
  )
}

export default ReactQueryExecutor