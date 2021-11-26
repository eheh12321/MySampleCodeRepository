package CodingTestMemory.자바의정석.Chap8;

class TryWithResourcesEx {
    public static void main(String[] args) {
        try(CloseableResources cr = new CloseableResources()) {
            cr.exceptionWork(false);
        } catch (WorkException e) {
            e.printStackTrace();
        } catch (CloseException e) {
            e.printStackTrace();
        }
        System.out.println();

        try(CloseableResources cr = new CloseableResources()) {
            cr.exceptionWork(true);
        } catch (WorkException e) {
            e.printStackTrace();
        } catch (CloseException e) {
            e.printStackTrace();
        }
    }
}

class CloseableResources implements AutoCloseable {

    void exceptionWork(boolean exception) throws WorkException {
        System.out.println("exceptionWork(" + exception + ")가 호출됨");

        if(exception) {
            throw new WorkException("WorkException 발생!");
        }
    }

    @Override
    public void close() throws CloseException {
        System.out.println("close()가 호출됨");
        throw new CloseException("CloseException 발생!");
    }
}

/**
 * 사용자 정의 예외
 */
class WorkException extends Exception {
    WorkException(String msg) {
        super(msg);
    }
}

class CloseException extends Exception {
    CloseException(String msg) {
        super(msg);
    }
}