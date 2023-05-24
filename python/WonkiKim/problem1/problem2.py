import threading
import time

processTimeList = [3, 5, 6]


class Adder(threading.Thread):
    tik = 0
    number = 0
    lock = threading.Lock()

    def __init__(self, process_time):
        super().__init__()
        self.tik = time.time()
        self.process_time = process_time

    def run(self):

        while True:
            self.lock.acquire()
            Adder.number += self.process_time
            self.lock.release()
            tok = time.time()
            print("{0}sec".format(tok - self.tik))
            print("adder{0}: {1}->{2}".format(self.process_time, Adder.number - self.process_time, Adder.number))
            time.sleep(self.process_time)

            tok = time.time()
            if tok - self.tik < 60:
                continue
            break


for i in processTimeList:
    thread = Adder(i)
    thread.start()
