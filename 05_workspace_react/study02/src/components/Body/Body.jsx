import Section from './components/Section/Section'
import Side from './components/Side/Side'
import styles from './Body.module.css'

const Body = () => {
  return (
    <div className={styles.body}>
      <Section />
      <Side />
    </div>
  )
}

export default Body
