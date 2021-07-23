import './styles.css';

type Props = {
  title: string;
  children: React.ReactNode;
}

const MainCard = ({ title, children } :Props) => {
  return (
    <div className="calculadora-card">
      <h1 className="auth-card-title">
        {title}
      </h1>      
        {children}      
    </div>
  )
}

export default MainCard;