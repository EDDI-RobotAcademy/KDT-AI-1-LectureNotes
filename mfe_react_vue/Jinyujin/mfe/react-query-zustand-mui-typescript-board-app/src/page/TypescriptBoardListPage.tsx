import React, { useEffect } from 'react'
import { Button, CircularProgress, Container, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography } from '@mui/material'
import { Link, useNavigate } from 'react-router-dom'
import { fetchBoardList, useBoardListQuery } from '../api/BoardApi'
import useBoardStore from '../store/BoardStore'

const TypescriptBoardListPage = () => {
    const { data: boards, isLoading, isError } = useBoardListQuery()
    const setBoards = useBoardStore((state) => state.setBoards)
    const navigate = useNavigate()

    useEffect(() => {
        const fetchData = async () => {
            const data = await fetchBoardList()
            console.log(data)
            setBoards(data)
        }

        fetchData()
    }, [setBoards])

    if (isLoading) {
        return <CircularProgress />
    }

    if (isError) {
        return <Typography>리스트를 가져오는 도중 에러가 발생했습니다!</Typography>
    }

    const handleRowClick = (boardId: number) => {
        navigate(`/react-query-zustand-mui-typescript-board-app/read/${boardId}`)
    }

    return (
        <Container maxWidth="lg">
            <h2>안녕 React-Query + Zustand + Typescript Board App이야!</h2>
            <Button component={Link} to="/react-query-zustand-mui-typescript-board-app/register" variant="contained"
                color="primary" style={{ marginTop: '20px' }}>
                글쓰기
            </Button>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="board table">
                    <TableHead>
                        <TableRow>
                            <TableCell style={{ width: '50%' }}>제목</TableCell>
                            <TableCell align='right'>작성자</TableCell>
                            <TableCell align='right'>작성일자</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {boards?.length === 0 ? (
                            <TableRow>
                                <TableCell colSpan={3} align='center'>현재 등록된 게시물이 없습니다!</TableCell>
                            </TableRow>
                        ) : (
                            boards?.map((board) => (
                                <TableRow key={board.boardId} onClick={() => handleRowClick(board.boardId)} style={{ cursor: 'pointer' }}>
                                    <TableCell>{board.title}</TableCell>
                                    <TableCell>{board.writer}</TableCell>
                                    <TableCell>{board.createDate}</TableCell>
                                </TableRow>
                            ))
                        )}
                    </TableBody>
                </Table>
            </TableContainer>
        </Container>
    )
}

export default TypescriptBoardListPage