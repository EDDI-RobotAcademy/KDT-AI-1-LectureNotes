import React from 'react'


const Header = () => {
  const headerStyles ={
    padding: '20px',
    lineHeight: '1.5em',
    color:'#EF6C00',
    textAlign: 'center'
  }
  
    return (
  <header style={headerStyles} className='header.styles'>
    <h1> Todo!</h1>
    <p>브라우저 localStrorage</p>
  </header>
  )
}
export default Header