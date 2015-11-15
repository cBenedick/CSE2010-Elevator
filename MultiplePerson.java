// move method
// assume riders and up



public ArrayList<PassengerReleased> move() {
		if (!continueOperate()) return null;
		
		ArrayList<PassengerReleased> released =
					new ArrayList<PassengerReleased>();
		
		PassengerRequest request = this.servingQueue.remove();
		
		long currentTime = Math.max(this.currentTime.getTime(),
				request.getTimePressedButton().getTime()); // whichever happened latest
		
		long timeInMiliseconds = currentTime + 
				this.doorDelta*1000 +  // delta to open the door
				1000*this.timeMoveOneFloor* (Math.abs(currentFloor -request.getFloorFrom()))+
				// time to get to the passenger's floor
				1000*this.timeMoveOneFloor* (Math.abs(request.getFloorFrom() -request.getFloorTo()))+
				// time to move to the destination
				this.doorDelta*1000; // delta to close the door

		PassengerReleased requestReleased = new PassengerReleased(request, 
				new Time(timeInMiliseconds));
		

		
		released.add(requestReleased);
		if (verbose) {
			StringBuilder sb = new StringBuilder();
			sb.append(currentFloor+" / " + request.getFloorFrom() + " / " +request.getFloorTo()+" | ");
			sb.append(request.getTimePressedButton() + " / " +
					new Time(timeInMiliseconds));
			
			System.out.println(new String(sb));
		}
		this.currentTime.setTime(timeInMiliseconds);
		currentFloor = request.getFloorTo();
		return released;
	}

	public boolean continueOperate() {
		if(this.servingQueue.isEmpty()) {
			return false;
		} else{
			return true;
		}
	}
