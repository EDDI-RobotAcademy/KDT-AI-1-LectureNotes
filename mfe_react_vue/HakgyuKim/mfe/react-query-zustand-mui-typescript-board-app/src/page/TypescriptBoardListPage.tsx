import React from 'react'
import { Button, Container, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material'
import { Link } from 'react-router-dom'
import { useBoardListQuery } from '../api/BoardApi'

const TypescriptBoardListPage = () => {
  const { data: boards, isLoading, isError } = useBoardListQuery()

  return (
    <Container maxWidth='lg'>
      <h2>안녕 React-Query + Zustand + Typescript + React Board App이야!</h2>
      <Button component={Link} to="/react-query-zustand-mui-typescript-board-app/register" variant="contained"
                color='primary' style={{ marginTop: '20px '}}>
        글쓰기
      </Button>
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} aria-label="board table">
            <TableHead>
              <TableRow>
                <TableCell style={{ width: '50%' }}>제목</TableCell>
                <TableCell align='right'>작성자</TableCell>
                <TableCell align='right'>작성 날짜</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              { boards.length === 0 ? (
                <TableRow>
                  <TableCell colSpan={3} align='center'>현재 등록된 게시물이 없습니다!</TableCell>
                </TableRow>
              ) : (
                <p>hi</p>
              )}
            </TableBody>
          </Table>
        </TableContainer>
    </Container>

  )
}

export default TypescriptBoardListPage