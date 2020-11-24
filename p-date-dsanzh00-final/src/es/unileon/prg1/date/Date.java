package es.unileon.prg1.date;

public class Date {

	/**
	 * Declaracion de variables
	 */
	private int day = 1;
	private int month = 1;
	private int year = 2017;

	/**
	 * Constructor
	 * @param day
	 * @param month
	 * @param year
	 * @throws DateException
	 */
	public Date(int day, int month, int year) throws DateException{
		
		/**
		 *  Comprobamos que el año sea correcto
		*/
		if(year <= 0 
				){
			throw new DateException("Año " + month + " no valido. El año no puede ser negativo.");
		}else{
			this.year = year;
		}
		/**
		 *  Comprobamos que el mes sea correcto
		*/
		if (month <= 0 || month >= 13) {
			throw new DateException("Mes " + month + " no valido. Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}
		/**
		 *  Comprobamos que el dia sea correcto
		*/
		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(day <= 0 || day > 31) {
					throw new DateException("Día " + day + " no válido. Valores posibles entre 1 y 31.");
				}else {
					this.day = day;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(day <= 0 || day > 30) {
					throw new DateException("Día " + day + " no válido. Valores posibles entre 1 y 30.");
				}else {
					this.day = day;
				}
				break;
			default:
				if(day <= 0 || day > 28) {
					throw new DateException("Día " + day + " no válido. Valores posibles entre 1 y 28.");
				}else {
					this.day = day;
				}			
		}

	}
	public Date() {
		
	}
	
	public Date(Date aDay) {
		aDay = new Date();
		
	
	}

	public void setYear(int year) throws DateException{
		/**
		 *  Comprobamos que el año sea correcto
		*/
		if(year <= 0 
				){
			throw new DateException("Año " + month + " no valido. El año no puede ser negativo.");
		}else{
			this.year = year;
		}
	}

	public int getYear(){
		return year;
	}

	/**
	 * Comprobamos si es el mismo anio
	 * @param another
	 * @return
	 */
	public boolean isSameYear(Date another){

		boolean mismoAnio = false;

		if(this.year == another.getYear()){
			mismoAnio = true;
			System.out.println("¿Tienen el mismo año?");
		}else{
			mismoAnio = false;
			System.out.println("¿Tienen el mismo año?");
		}

		return mismoAnio;
	}

	public void setMonth(int month) throws DateException{
		/**
		 *  Comprobamos que el mes sea correcto
		*/
		if (month <= 0 || month >= 13) {
			throw new DateException("Mes " + month + " no valido. Valores posibles entre 1 y 12.");
		} else {
			this.month = month;
		}
	}

	public int getMonth(){
		return month;
	}

	/**
	 * Comprobamos si es el mismo mes
	 * @param another
	 * @return
	 */
	public boolean isSameMonth(Date another){

		boolean mismoMes = false;

		if(this.month == another.getMonth()){
			mismoMes = true;
			System.out.println("¿Tienen el mismo mes?");
		}else{
			mismoMes = false;
			System.out.println("¿Tienen el mismo mes?");
		}

		return mismoMes;
	}

	public void setDay(int day) throws DateException{
		/**
		 *  Comprobamos que el dia sea correcto
		*/
		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(day <= 0 || day > 31) {
					throw new DateException("Día " + day + " no válido. Valores posibles entre 1 y 31.");
				}else {
					this.day = day;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(day <= 0 || day > 30) {
					throw new DateException("Día " + day + " no válido. Valores posibles entre 1 y 30.");
				}else {
					this.day = day;
				}
				break;
			default:
				if(day <= 0 || day > 28) {
					throw new DateException("Día " + day + " no válido. Valores posibles entre 1 y 28.");
				}else {
					this.day = day;
				}			
		}

	}

	public int getDay(){
		return day;
	}

	/**
	 * Comprobamos si es el mismo dia
	 * @param another
	 * @return
	 */
	public boolean isSameDay(Date another){

		boolean mismoDia = false;

		if(this.day == another.getDay()){
			mismoDia = true;
			System.out.println("¿Tienen el mismo día?");
		}else{
			mismoDia = false;
			System.out.println("¿Tienen el mismo día?");
		}

		return mismoDia;
	}

	/**
	 * Comprobamos si es la misma fecha
	 * @param another
	 * @return
	 */
	public boolean isSame(Date another){

		boolean igual = false;

		if((this.day == another.getDay()) && (this.month == another.getMonth()) && (this.year == another.getYear())){
			igual = true;
			System.out.println("¿Es la misma fecha?");
		}else{
			igual = false;
			System.out.println("¿Es la misma fecha?");
		}

		return igual;
	}

	public Date tomorrow() {
		
		Date tomorrow;
		
		int aDay = this.day;
		int aMonth = this.month;
		int aYear = this.year;
		tomorrow = new Date();
		
		aDay++;
		aMonth = month;
		/**
		 * Comprobamos si hay que cambiar de mes 
		 */
		if(aDay > daysOfMonth()) {
			aDay = 1;
			aMonth = month + 1;
		}
		/**
		 * Comprobamos si hay que cambiar de año
		 */
		if(aMonth > 12) {
			aDay = 1;
			aMonth = 1;
			aYear = this.year + 1;
		}else {
			aYear = this.year;
		}
		try {
			tomorrow.setDay(aDay); 
			tomorrow.setMonth(aMonth);
			tomorrow.setYear(aYear);
		}catch (DateException e) {
			e.printStackTrace();
		}
		return tomorrow;
	}
	/**
	 * Devuelve el nombre del mes
	 * @return
	 */
	public String getMonthName(){

		String nombreMes = "ERROR";

		switch(month){
			case 1:
				nombreMes = "January";
				break;
			case 2:
				nombreMes = "February";
				break;
			case 3: 
				nombreMes = "March";
				break;
			case 4:
				nombreMes = "April";
				break;
			case 5:
				nombreMes = "May";
				break;
			case 6:
				nombreMes = "June";
				break;
			case 7:
				nombreMes = "July";
				break;
			case 8:
				nombreMes = "August";
				break;
			case 9:
				nombreMes = "September";
				break;
			case 10:
				nombreMes = "October";
				break;
			case 11:
				nombreMes = "November";
				break;
			default:
				nombreMes = "December";
		}

		return nombreMes;
	}

	/**
	 * Devuelve el numero de dias del mes
	 * @return
	 */
	public int daysOfMonth(){

		int dias_del_mes = 0;

		switch(this.getMonth()){

			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				dias_del_mes = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				dias_del_mes = 30;
				break;
			default: 
				dias_del_mes = 28;
		}

		return dias_del_mes;
	}

	/**
	 * Devuelve el nombre de la estacion
	 * @return
	 */
	public String getSeasonName(){

		String season = " ";

		switch(month) {
			case 1: 
			case 2:
			case 12:
				season = "Winter";
				break;	
			case 3:
			case 4:
			case 5:
				season = "Spring";
				break;
			case 6:
			case 7:
			case 8:
				season = "Summer";
				break;
			case 9:
			case 10:
			case 11:
				season = "Autumn";
				break;
		}

		return season;
	}

	/**
	 * Devuelve los meses que faltan para acabar el anio
	 * @return
	 */
	public String getMonthsLeft(){

		StringBuffer meses = new StringBuffer();
		int month=this.month;
		Date fecha = this;

		for(int i = this.month; i < 12; i++){
			month++;
			try {
				fecha.setMonth(month);
			} catch (DateException e) {
				e.printStackTrace();
			}
			
			meses.append(fecha.getMonthName() + " ");
			
		}

		return meses.toString();
	}
	
	/**
	 * Metodo toString
	 */
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	/**
	 * Devuelve el numero de dias hasta el final de mes
	 * @return
	 */
	public String getDaysLeftOfMonth(){

		StringBuffer dias = new StringBuffer();
		Date fecha = this;

		for(int i = this.day; i < daysOfMonth(); i++){
			fecha = fecha.tomorrow();
			dias.append(fecha.toString() + " ");
			
		}

		return dias.toString();
	}

	/**
	 * Imprime los meses con el mismo numero de dias que el mes de la fecha
	 * @return
	 */
	public String getMonthsSameDays(){

		String meses = " ";

		switch(this.month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				meses = "January March May July August October December ";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				 meses = "April June September November ";
				break;
			default: 
				meses = "February ";
		}

		return meses;
	}

	/**
	 * Dias desde principio de anio hasta la fecha
	 * @return
	 * @throws DateException 
	 */
	public int daysPast() throws DateException{

		int nums = 0;

		if(this.getMonth() == 1 && this.getDay() != 1) {
			nums += this.getDay()-1;
		}else {
			int mes = this.getMonth();
			for(int i = 1; i < this.month ; i++) {
				this.setMonth(i);
				nums = nums + this.daysOfMonth();
			}
			if(this.getDay() == 31 && mes == 12 ) {
				nums = 365 - (daysOfMonth() - getDay())-1;
			}
		}
		return nums;
	}

	/**
	 * Numero de intentos hasta general una fecha aleatoria igual que la fecha introducida (bucle do-while)
	 * @return
	 *
	public int numRandomTriesEqualDate(){

		int day_ = 0;
		int month_ = 0;
		int attemps = 0;
		
		do{
			day_ = (int)((Math.random()*31)+1);
			month_ = (int)((Math.random()*12)+1);
			attemps = attemps +1;
		}while((day_ != this.day) && (month_ != this.month));
		
		return attemps;
	}
	*/
	
	/**
	 * Numero de intentos hasta general una fecha aleatoria igual que la fecha introducida (bucle while)
	 * @return
	 */
	public int numRandomTriesEqualDate(){

		int day2_ = 0;
		int month2_ = 0;
		int attemps2 = 0;

		while((day2_ != this.day) && (month2_ != this.month)){
			day2_ = (int)((Math.random()*31)+1);
			month2_ = (int)((Math.random()*12)+1);
			attemps2 = attemps2 + 1;
		}

		return attemps2;
	}
	
	public String dayOfWeek(int day) throws DateException {
		
		String valor_dia = " ";
		int diaSemana = this.daysPast() % 7;
		
		switch(diaSemana) {
			case 0:
				valor_dia = "Monday";
				break;
			case 1:
				valor_dia = "Tuesday";
				break;
			case 2:
				valor_dia = "Wednesday";
				break;
			case 3:
				valor_dia = "Thursday";
				break;
			case 4:
				valor_dia = "Friday";
				break;
			case 5:
				valor_dia = "Saturday";
				break;
			case 6:
				valor_dia = "Sunday";
				break;
		}    
	    return valor_dia;
	}	

}
