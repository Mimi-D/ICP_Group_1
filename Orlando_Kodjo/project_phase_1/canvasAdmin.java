public class canvasAdmin extends canvasUser{

    public canvasAdmin(String Email){
        super(Email);
    }
    public void makeFaculty(String EmailtobeFaculty){
        canvasFaculty m = new canvasFaculty(EmailtobeFaculty);
        projectPhase1.facultyobj.add(m);
    }
}
