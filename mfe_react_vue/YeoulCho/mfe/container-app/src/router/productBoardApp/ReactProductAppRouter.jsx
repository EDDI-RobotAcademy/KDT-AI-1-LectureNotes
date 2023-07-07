import React, { Suspense } from 'react'
import { Routes,Route } from 'react-router-dom'

import ProductListPage from 'reactProductApp/ProductListPage'
import ProductModifyPage from 'reactProductApp/ProductModifyPage'
import ProductReadPage from 'reactProductApp/ProductReadPage'
import ProductRegisterPage from 'reactProductApp/ProductRegisterPage'

const ReactProductAppRouter = () =>{
  return (
    <div>
        <div style={{ position: 'relative' }}>
          <Suspense fallback={<div>로딩중..........</div>}>
            <Routes>
                <Route path="/react-product-app" element={<ProductListPage/>}/>
                <Route path="/react-product-app/register" element={<ProductRegisterPage/>}/>
                <Route path="/react-product-app/read/:productId" element={<ProductReadPage/>}/>
                <Route path="/react-product-app/modify/:productId" element={<ProductModifyPage/>}/>
            </Routes>
          </Suspense>
            
        </div>
    </div>
  )
}

export default ReactProductAppRouter