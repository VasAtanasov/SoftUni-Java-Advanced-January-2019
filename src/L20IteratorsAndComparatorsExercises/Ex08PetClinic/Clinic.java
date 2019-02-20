package L20IteratorsAndComparatorsExercises.Ex08PetClinic;

import java.util.Iterator;

public class Clinic implements Iterable<Pet> {
    private String name;
    private Pet[] rooms;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.setRooms(rooms);

    }

    private void setRooms(int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new Pet[roomsCount];
    }

    public boolean add(Pet pet) {
        int room = this.getMiddleRoom();

        for (int i = 0; i < this.rooms.length; i++) {
            if (i % 2 != 0) {
                room -= i;
            } else {
                room += i;
            }

            if (this.rooms[room] == null) {
                this.rooms[room] = pet;
                return true;
            }
        }
        return false;
    }

    private int getMiddleRoom() {
        return this.rooms.length / 2;
    }

    public boolean hasEmptyRooms() {
        for (Pet room : rooms) {
            if (room == null) {
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        int midRoom = this.getMiddleRoom();

        for (int i = midRoom; i < this.rooms.length; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }

        for (int i = 0; i < midRoom; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }

        return false;
    }

    public String getRoomInfo(int roomNumber) {
        if (this.rooms[roomNumber] == null) {
            return "Room empty";
        }
        return this.rooms[roomNumber].toString();
    }

    public Pet get(int roomNumber) {
        return this.rooms[roomNumber];
    }

    @Override
    public Iterator<Pet> iterator() {
        return new ClinicIterator();
    }

    private class ClinicIterator implements Iterator<Pet> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Pet next() {
            return rooms[this.index++];
        }
    }
}
