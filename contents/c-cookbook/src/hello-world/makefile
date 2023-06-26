CC = gcc
CFLAGS = -Wall -Wextra -g
TARGET_DIR = target

SRCS = main.c
OBJS = $(addprefix $(TARGET_DIR)/, $(SRCS:.c=.o))
TARGET = $(TARGET_DIR)/program

.PHONY: all clean run

all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) $^ -o $@

$(TARGET_DIR)/%.o: %.c
	@mkdir -p $(TARGET_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

run: $(TARGET)
	$(TARGET)

clean:
	rm -rf $(TARGET_DIR)
