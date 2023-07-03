import React, { useEffect, useRef } from 'react'

const VuetifyBoardAppReadRouter = () => {
    const vuetifyBoardReadRef = useRef(null)

    useEffect(() => {
        const loadRemoteComponent = async () => {
            const { readBootstrapMount } = await import('vuetifyTailwindBoardApp/boardReadBootstrap')
            readBootstrapMount(vuetifyBoardReadRef.current)
        }

        loadRemoteComponent()
    }, [vuetifyBoardReadRef])

    return (
        <div>
            <div>
                <div style={{ position: 'relative' }} ref={vuetifyBoardReadRef} />
            </div>
        </div>
    )
}

export default VuetifyBoardAppReadRouter