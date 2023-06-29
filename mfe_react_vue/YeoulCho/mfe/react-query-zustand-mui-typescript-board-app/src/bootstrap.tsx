import React from "react";
import ReactDOM from "react-dom";

import ReactQueryZustandMuiTypescriptBoardApp from './ReactQueryZustandMuiTypescriptBoardApp'
import { BrowserRouter } from 'react-router-dom'
import {QueryClient, QueryClientProvider} from "react-query"

const queryClient = new QueryClient({
    defaultOptions:{
        queries: {
            refetchOnWindowFocus: false,
            retry: false,
            staleTime: 30000,
        }
    }
})

ReactDOM.render(
    <React.StrictMode>
        <QueryClientProvider client={queryClient}>
            <BrowserRouter>
                <ReactQueryZustandMuiTypescriptBoardApp/>
            </BrowserRouter>
        </QueryClientProvider>
    </React.StrictMode>,    
    document.getElementById("react-query-zustand-mui-typescript-board-app")
);

