import React from 'react'
import styles from '../styles/Header.module.css'

const Header = () => {
  const headerStyles = {
    padding: '20px',
    lineHeight: '1.5em',
    color: '#EF6C00',
    //textAlign: 'center'
  }
  return (
    <header style={headerStyles} className={styles.header}>
      <h1>Todo!</h1>
      <p>브라우저 localStorage를 활용해서 저장해보자!</p>
    </header>
  )
}

export default Header