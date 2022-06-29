import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';


export default function CourseInfo({course}) {
  console.log(course);
  return (
    <Card sx={{ minWidth: 275 }}>
      <CardContent>
        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
          {course.name}
        </Typography>
        <Typography variant="h5" component="div">
          {course.credits}
        </Typography>
        <Typography sx={{ mb: 1.5 }} color="text.secondary">
          {course.component}
        </Typography>
        <Typography variant="body2">
          
          <br />
        </Typography>
      </CardContent>
      <CardActions>
        <Button size="small">Mas</Button>
      </CardActions>
    </Card>
  );
}