import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

const ProductModifyForm = ({ product, isLoading, onModify }) => {
  const [title, setTitle] = useState("")
  const [content, setContent] = useState("")

  const handleChangeTitle = (e) => {
    setTitle(e.target.value)
  }

  const handleChangeContent = (e) => {
    setContent(e.target.value)
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    
    onModify(product.prdocutId, title, content, product.writer)
  }

  useEffect(() => {
    if (product) {
      setTitle(product.title)
      setContent(product.content)
    }
  }, [product])

  return (
    <div align="center">
      <h2>게시물 수정</h2>
      { isLoading && "로딩중 .........." }
      { !isLoading && product && (
        <div>
            <form onSubmit={handleSubmit}>
                <table>
                    <tbody>
                        <tr>
                            <td>번호</td>
                            <td>
                                <input type="text" value={product.productId} disabled/>
                            </td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td>
                                <input type="text" value={title} onChange={handleChangeTitle}/>
                            </td>
                        </tr>
                        <tr>
                            <td>작성자</td>
                            <td>
                                <input type="text" value={product.writer} disabled/>
                            </td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td>
                                <textarea value={content} rows="5" onChange={handleChangeContent}/>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <div>
                    <button type="submit">수정</button>
                    <Link to={`/read/${product.productId}`}>취소</Link>
                </div>
            </form>
        </div>
      )}
    </div>
  )
}

export default ProductModifyForm